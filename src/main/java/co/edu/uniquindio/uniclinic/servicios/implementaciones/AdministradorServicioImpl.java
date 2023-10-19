package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.admin.*;
import co.edu.uniquindio.uniclinic.dto.medico.HorarioDTO;
import co.edu.uniquindio.uniclinic.excepciones.*;
import co.edu.uniquindio.uniclinic.modelo.entidades.Cita;
import co.edu.uniquindio.uniclinic.modelo.entidades.Medico;
import co.edu.uniquindio.uniclinic.modelo.entidades.HorarioMedico;
import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;
import co.edu.uniquindio.uniclinic.modelo.enums.EstadoUsuario;
import co.edu.uniquindio.uniclinic.repositorios.CitaRepo;
import co.edu.uniquindio.uniclinic.repositorios.HorarioRepo;
import co.edu.uniquindio.uniclinic.repositorios.MedicoRepo;
import co.edu.uniquindio.uniclinic.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    private final MedicoRepo medicoRepo;
    private final CitaRepo citaRepo;
    private final HorarioRepo horarioRepo;

    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws ResourceAlreadyExistsException {
        if(estaRepetidaCedula(medicoDTO.cedula())) {
            throw new ResourceAlreadyExistsException("La cédula " + medicoDTO.cedula() + " ya está en uso");
        }

        if(estaRepetidoCorreo(medicoDTO.correo())) {
            throw new ResourceAlreadyExistsException("El correo " + medicoDTO.correo() + " ya está en uso");
        }

        Medico medico = new Medico();
        copiarAtributosComunesMedico(medico, medicoDTO.cedula(), medicoDTO.telefono(), medicoDTO.nombre(),
                medicoDTO.especialidad(), medicoDTO.ciudad(), medicoDTO.correo(), medicoDTO.urlFoto());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(medicoDTO.contrasenia());
        medico.setContrasenia(passwordEncriptada);
        medico.setEstado(EstadoUsuario.ACTIVO);

        Medico medicoNuevo = medicoRepo.save(medico);
        asignarHorariosMedico(medicoNuevo, medicoDTO.horarios());

        return medicoNuevo.getCodigo();
    }

    @Override
    public int actualizarMedico(InfoMedicoDTO medicoDTO) throws ResourceNotFoundException,
            ResourceAlreadyExistsException {
        Optional<Medico> opcional = medicoRepo.findById(medicoDTO.codigo());

        if (opcional.isEmpty() || estaMedicoActivo(opcional.get())) {
            throw new ResourceNotFoundException("No existe un médico con el código " + medicoDTO.codigo());
        }

        Medico buscado = opcional.get();

        if (estaRepetidaCedulaExceptoPropio(buscado, medicoDTO.cedula())) {
            throw new ResourceAlreadyExistsException("La cédula " + medicoDTO.cedula() + " ya está en uso");
        }

        if (estaRepetidoCorreoExceptoPropio(buscado, medicoDTO.correo())) {
            throw new ResourceAlreadyExistsException("El correo " + medicoDTO.correo() + " ya está en uso");
        }

        copiarAtributosComunesMedico(buscado, medicoDTO.cedula(), medicoDTO.telefono(), medicoDTO.nombre(),
                medicoDTO.especialidad(), medicoDTO.ciudad(), medicoDTO.correo(), medicoDTO.urlFoto());

        actualizarHorariosMedico(buscado, medicoDTO.horarios());
        medicoRepo.save(buscado);

        return buscado.getCodigo();
    }

    private void copiarAtributosComunesMedico(Medico medico, String cedula, String telefono, String nombre,
                                              Especialidad especialidad, Ciudad ciudad, String correo,
                                              String urlFoto) {
        medico.setCedula(cedula);
        medico.setTelefono(telefono);
        medico.setNombre(nombre);
        medico.setEspecialidad(especialidad);
        medico.setCiudad(ciudad);
        medico.setCorreo(correo);
        medico.setUrlFoto(urlFoto);
    }

    private void asignarHorariosMedico(Medico medicoNuevo, List<HorarioDTO> horarios) {
        for( HorarioDTO h : horarios ) {
            HorarioMedico hm = new HorarioMedico();
            hm.setDia(h.dia());
            hm.setHoraInicio(h.horaInicio());
            hm.setHoraFin(h.horaFin());
            hm.setMedico(medicoNuevo);

            horarioRepo.save(hm);
        }
    }

    private void actualizarHorariosMedico(Medico medico, List<HorarioDTO> nuevosHorarios) {
        // Obtener los horarios actuales del médico
        List<HorarioMedico> horariosActuales = horarioRepo.findAllByMedicoCodigo(medico.getCodigo());

        // Iterar sobre los nuevos horarios y actualizar o agregar
        for (HorarioDTO nuevoHorario : nuevosHorarios) {
            boolean horarioExistente = false;

            for (HorarioMedico horarioActual : horariosActuales) {
                if (sonHorariosIguales(horarioActual, nuevoHorario)) {
                    horarioExistente = true;
                    break;
                }
            }

            if (!horarioExistente) {
                // Crear un nuevo HorarioMedico y asociarlo al médico
                HorarioMedico hmNuevo = new HorarioMedico();
                hmNuevo.setDia(nuevoHorario.dia());
                hmNuevo.setHoraInicio(nuevoHorario.horaInicio());
                hmNuevo.setHoraFin(nuevoHorario.horaFin());
                hmNuevo.setMedico(medico);

                horarioRepo.save(hmNuevo);
            }
        }

        // Eliminar horarios que ya no son necesarios
        for (HorarioMedico horarioActual : horariosActuales) {
            boolean horarioEliminado = true;

            for (HorarioDTO nuevoHorario : nuevosHorarios) {
                if (sonHorariosIguales(horarioActual, nuevoHorario)) {
                    horarioEliminado = false;
                    break;
                }
            }

            if (horarioEliminado) {
                horarioRepo.delete(horarioActual);
            }
        }
    }

    private boolean sonHorariosIguales(HorarioMedico horario, HorarioDTO nuevoHorario) {
        return horario.getDia().equals(nuevoHorario.dia()) &&
                horario.getHoraInicio().equals(nuevoHorario.horaInicio()) &&
                horario.getHoraFin().equals(nuevoHorario.horaFin());
    }

    private boolean estaRepetidaCedula(String cedula) {
        return medicoRepo.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo) {
        return medicoRepo.findByCorreo(correo) != null;
    }

    private boolean estaRepetidaCedulaExceptoPropio(Medico medico, String cedula) {
        // Buscar un médico con la misma cédula, excluyendo al médico actual
        Medico medicoExistente = medicoRepo.findByCedulaAndCodigoNot(cedula, medico.getCodigo());
        return medicoExistente != null;
    }

    private boolean estaRepetidoCorreoExceptoPropio(Medico medico, String correo) {
        // Buscar un médico con el mismo correo, excluyendo al médico actual
        Medico medicoExistente = medicoRepo.findByCorreoAndCodigoNot(correo, medico.getCodigo());
        return medicoExistente != null;
    }

    @Override
    public void eliminarMedico(int codigo) throws ResourceNotFoundException {
        Optional<Medico> opcional = medicoRepo.findById(codigo);

        if(opcional.isEmpty() || estaMedicoActivo(opcional.get())) {
            throw new ResourceNotFoundException("No existe un médico con el código " + codigo);
        }

        Medico buscado = opcional.get();
        buscado.setEstado(EstadoUsuario.INACTIVO);

        medicoRepo.save(buscado);
    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws ResourceNotFoundException {
        List<Medico> medicos = medicoRepo.findAllByEstado(EstadoUsuario.ACTIVO);

        if(medicos.isEmpty()) {
            throw new ResourceNotFoundException("No hay médicos registrados");
        }

        return medicos.stream().map(m -> new ItemMedicoDTO(
                m.getCodigo(),
                m.getCedula(),
                m.getNombre(),
                m.getUrlFoto(),
                m.getEspecialidad()
        )).toList();
    }

    @Override
    public InfoMedicoDTO obtenerMedico(int codigo) throws ResourceNotFoundException {
        Optional<Medico> opcional = medicoRepo.findById(codigo);

        if(opcional.isEmpty() || estaMedicoActivo(opcional.get())) {
            throw new ResourceNotFoundException("No existe un médico con el código " + codigo);
        }

        Medico buscado = opcional.get();

        List<HorarioMedico> horarios = horarioRepo.findAllByMedicoCodigo(codigo);
        List<HorarioDTO> horariosDTO = new ArrayList<>();

        for(HorarioMedico h : horarios) {
            horariosDTO.add( new HorarioDTO(
                    h.getDia(),
                    h.getHoraInicio(),
                    h.getHoraFin()
            ) );
        }

        return new InfoMedicoDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCorreo(),
                buscado.getCedula(),
                buscado.getTelefono(),
                buscado.getCiudad(),
                buscado.getEspecialidad(),
                buscado.getUrlFoto(),
                horariosDTO
        );
    }

    private boolean estaMedicoActivo(Medico medico) {
        return medico.getEstado() != EstadoUsuario.ACTIVO;
    }

    @Override
    public List<ItemConsultaDTO> listarConsultasMedico(int codigoMedico) throws ResourceNotFoundException {
        List<Cita> citas = citaRepo.findCitasCompletadasMedico(codigoMedico);
        List<ItemConsultaDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()) {
            throw new ResourceNotFoundException("No se han encontrado consultas realizadas por este médico");
        }

        for(Cita c : citas) {
            respuesta.add( new ItemConsultaDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getFechaCita(),
                    c.getMotivo()
            ) );
        }

        return respuesta;
    }

}
