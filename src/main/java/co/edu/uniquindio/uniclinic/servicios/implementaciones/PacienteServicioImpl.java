package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.autenticacion.NuevaPasswordDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.*;
import co.edu.uniquindio.uniclinic.excepciones.ResourceAlreadyExistsException;
import co.edu.uniquindio.uniclinic.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniclinic.modelo.entidades.*;
import co.edu.uniquindio.uniclinic.modelo.enums.*;
import co.edu.uniquindio.uniclinic.repositorios.*;
import co.edu.uniquindio.uniclinic.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;
    private final MedicoRepo medicoRepo;
    private final HorarioRepo horarioRepo;
    private final CitaRepo citaRepo;
    private final AtencionRepo atencionRepo;
    private final RecetaMedicaRepo recetaRepo;
    private final IncapacidadRepo incapacidadRepo;

    @Override
    public int registrarse(RegistroPacienteDTO pacienteDTO) throws ResourceAlreadyExistsException {
        if(estaRepetidaCedula(pacienteDTO.cedula())) {
            throw new ResourceAlreadyExistsException("Ya existe un paciente con la cédula " + pacienteDTO.cedula());
        }

        if(estaRepetidoCorreo(pacienteDTO.correo())) {
            throw new ResourceAlreadyExistsException("Ya existe un paciente con el correo " + pacienteDTO.correo());
        }

        Paciente paciente = new Paciente();
        copiarAtributosComunesPaciente(paciente, pacienteDTO.nombre(), pacienteDTO.correo(), pacienteDTO.cedula(),
                pacienteDTO.telefono(), pacienteDTO.ciudad(), pacienteDTO.eps(), pacienteDTO.tipoSangre(),
                pacienteDTO.urlFoto(), pacienteDTO.fechaNacimiento(), pacienteDTO.alergias());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(pacienteDTO.contrasenia());
        paciente.setContrasenia(passwordEncriptada);
        paciente.setEstado(EstadoUsuario.ACTIVO);

        Paciente pacienteNuevo = pacienteRepo.save(paciente);

        return pacienteNuevo.getCodigo();
    }

    @Override
    public int editarPerfil(InfoPacienteDTO infoPacienteDTO) throws ResourceNotFoundException,
            ResourceAlreadyExistsException {
        Optional<Paciente> pacienteOptional = pacienteRepo.findById(infoPacienteDTO.codigo());

        if(pacienteOptional.isEmpty() || estaPacienteActivo(pacienteOptional.get())) {
            throw new ResourceNotFoundException("No se encontró ningún paciente con el código " +
                    infoPacienteDTO.codigo());
        }

        Paciente buscado = pacienteOptional.get();

        if(estaRepetidaCedulaExceptoPropio(buscado, infoPacienteDTO.cedula())) {
            throw new ResourceAlreadyExistsException("Ya existe un paciente con la cédula " + infoPacienteDTO.cedula());
        }

        if(estaRepetidoCorreoExceptoPropio(buscado, infoPacienteDTO.correo())) {
            throw new ResourceAlreadyExistsException("Ya existe un paciente con el correo " + infoPacienteDTO.correo());
        }

        copiarAtributosComunesPaciente(buscado, infoPacienteDTO.nombre(), infoPacienteDTO.correo(),
                infoPacienteDTO.cedula(), infoPacienteDTO.telefono(), infoPacienteDTO.ciudad(),
                infoPacienteDTO.eps(), infoPacienteDTO.tipoSangre(), infoPacienteDTO.urlFoto(),
                infoPacienteDTO.fechaNacimiento(), infoPacienteDTO.alergias());

        pacienteRepo.save(buscado);

        return buscado.getCodigo();
    }

    private void copiarAtributosComunesPaciente(Paciente paciente, String nombre, String correo, String cedula,
                                                String telefono, Ciudad ciudad, EPS eps, TipoSangre tipoSangre,
                                                String urlFoto, LocalDate fechaNacimiento, String alergias) {
        paciente.setNombre(nombre);
        paciente.setCorreo(correo);
        paciente.setCedula(cedula);
        paciente.setTelefono(telefono);
        paciente.setCiudad(ciudad);
        paciente.setEps(eps);
        paciente.setTipoSangre(tipoSangre);
        paciente.setUrlFoto(urlFoto);
        paciente.setFechaNacimiento(fechaNacimiento);
        paciente.setAlergias(alergias);
    }

    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCorreo(correo) != null;
    }

    private boolean estaRepetidaCedulaExceptoPropio(Paciente paciente, String cedula) {
        // Buscar un médico con la misma cédula, excluyendo al médico actual
        Paciente pacienteExistente = pacienteRepo.findByCedulaAndCodigoNot(cedula, paciente.getCodigo());
        return pacienteExistente != null;
    }

    private boolean estaRepetidoCorreoExceptoPropio(Paciente paciente, String correo) {
        // Buscar un médico con el mismo correo, excluyendo al médico actual
        Paciente pacienteExistente = pacienteRepo.findByCorreoAndCodigoNot(correo, paciente.getCodigo());
        return pacienteExistente != null;
    }

    @Override
    public void eliminarCuenta(int codigo) throws ResourceNotFoundException {
        Optional<Paciente> pacienteOptional = pacienteRepo.findById(codigo);

        if(pacienteOptional.isEmpty() || estaPacienteActivo(pacienteOptional.get())) {
            throw new ResourceNotFoundException("No se encontró ningún paciente con el código " + codigo);
        }

        Paciente paciente = pacienteOptional.get();
        paciente.setEstado(EstadoUsuario.INACTIVO);

        pacienteRepo.save(paciente);
    }

    @Override
    public InfoPacienteDTO verDetallePaciente(int codigo) throws ResourceNotFoundException {
        Optional<Paciente> pacienteOptional = pacienteRepo.findById(codigo);

        if(pacienteOptional.isEmpty() || estaPacienteActivo(pacienteOptional.get())) {
            throw new ResourceNotFoundException("No se encontró ningún paciente con el código " + codigo);
        }

        Paciente buscado = pacienteOptional.get();

        return new InfoPacienteDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCorreo(),
                buscado.getCedula(),
                buscado.getTelefono(),
                buscado.getCiudad(),
                buscado.getEps(),
                buscado.getTipoSangre(),
                buscado.getUrlFoto(),
                buscado.getFechaNacimiento(),
                buscado.getAlergias()
        );
    }

    @Override
    public int agendarCita(RegistroCitaDTO citaDTO) throws ResourceNotFoundException {
        List<Medico> medicos = medicoRepo.findAllByEstadoAndEspecialidad(EstadoUsuario.ACTIVO, citaDTO.especialidad());

        if(medicos.isEmpty()) {
            throw new ResourceNotFoundException("No se encontró ningún médico disponible para la especialidad " +
                    citaDTO.especialidad());
        }

        Cita cita = new Cita();
        cita.setFechaCreacion(LocalDateTime.now());
        cita.setFechaCita(citaDTO.fechaCita());
        cita.setMedico(obtenerMedicoDisponible(medicos, citaDTO.fechaCita()));
        cita.setMotivo(citaDTO.motivo());
        cita.setEstado(EstadoCita.PROGRAMADA);

        Paciente paciente = pacienteRepo.findPacienteActivo(citaDTO.codigoPaciente());
        cita.setPaciente(paciente);

        if(citaRepo.countCitasPendientesByPaciente(citaDTO.codigoPaciente()) >= 3) {
            throw new ResourceNotFoundException("El paciente con el código " + citaDTO.codigoPaciente() +
                    " ya tiene 3 citas pendientes");
        }

        Cita citaNueva = citaRepo.save(cita);

        return citaNueva.getCodigo();
    }

    private Medico obtenerMedicoDisponible(List<Medico> medicos, LocalDateTime fechaCita) throws ResourceNotFoundException {
        for(Medico m : medicos) {
            List<HorarioMedico> horarios = horarioRepo.findAllByMedicoCodigo(m.getCodigo());

            for(HorarioMedico h : horarios) {
                if(h.getDia().ordinal() == fechaCita.getDayOfWeek().getValue()) {
                    if(h.getHoraInicio().isBefore(fechaCita.toLocalTime()) &&
                            h.getHoraFin().isAfter(fechaCita.toLocalTime())) {
                        return m;
                    }
                }
            }
        }

        throw new ResourceNotFoundException("No se encontró ningún médico disponible para la fecha " + fechaCita);
    }

    @Override
    public List<ItemCitaDTO> listarCitasCompletadasPaciente(int codigoPaciente) throws ResourceNotFoundException {
        Optional<Paciente> pacienteOptional = pacienteRepo.findById(codigoPaciente);
        List<Cita> citas = citaRepo.findCitasCompletadasByPaciente(codigoPaciente);
        List<ItemCitaDTO> respuesta = new ArrayList<>();

        if(pacienteOptional.isEmpty() || estaPacienteActivo(pacienteOptional.get())) {
            throw new ResourceNotFoundException("No se encontró ningún paciente con el código " + codigoPaciente);
        }

        if(citas.isEmpty()) {
            throw new ResourceNotFoundException("No se han encontrado citas completadas para este paciente");
        }

        for(Cita c : citas) {
            respuesta.add(new ItemCitaDTO(
                    c.getCodigo(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad(),
                    c.getFechaCita(),
                    c.getMotivo()
            ));
        }

        return respuesta;
    }

    @Override
    public void filtrarCitas(FiltroBusquedaCitaDTO filtroBusquedaCitaDTO) throws Exception {

    }

    @Override
    public DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws ResourceNotFoundException {
        Optional<AtencionMedica> opcional = atencionRepo.findByCitaCodigo(codigoCita);

        if(opcional.isEmpty()) {
            throw new ResourceNotFoundException("No se encontró ninguna atención con el código de cita " +
                    codigoCita);
        }

        AtencionMedica buscado = opcional.get();

        return new DetalleAtencionMedicaDTO(
                buscado.getCodigo(),
                buscado.getCita().getMedico().getNombre(),
                buscado.getCita().getMedico().getEspecialidad(),
                buscado.getCita().getFechaCita(),
                buscado.getCita().getMotivo(),
                buscado.getCita().getEstado(),
                buscado.getNotas(),
                buscado.getDiagnostico(),
                buscado.getTratamiento()
        );
    }

    @Override
    public DetalleRecetaDTO verDetalleRecetaMedica(int codigoAtencion) throws ResourceNotFoundException {
        Optional<RecetaMedica> opcional = recetaRepo.findByAtencionMedicaCodigo(codigoAtencion);

        if(opcional.isEmpty()) {
            throw new ResourceNotFoundException("No se encontró ninguna receta con el código de atención " +
                    codigoAtencion);
        }

        RecetaMedica buscado = opcional.get();

        List<Medicamento> medicamentos = recetaRepo.findMedicamentosByCodigoReceta(buscado.getCodigo());
        List<MedicamentoDTO> medicamentosDTO = new ArrayList<>();

        for(Medicamento m : medicamentos) {
            medicamentosDTO.add(new MedicamentoDTO(
                    m.getNombre(),
                    m.getCantidad(),
                    m.getViaAdministracion(),
                    m.getDosis()
            ));
        }

        return new DetalleRecetaDTO(
                buscado.getAtencionMedica().getCita().getCodigo(),
                buscado.getDescripcion(),
                medicamentosDTO
        );
    }

    @Override
    public DetalleIncapacidadDTO verDetalleIncapacidad(int codigoAtencion) throws ResourceNotFoundException {
        Optional<Incapacidad> opcional = incapacidadRepo.findByAtencionMedicaCodigo(codigoAtencion);

        if(opcional.isEmpty()) {
            throw new ResourceNotFoundException("No se encontró ninguna incapacidad con el código de atención " +
                    codigoAtencion);
        }

        Incapacidad buscado = opcional.get();

        return new DetalleIncapacidadDTO(
                buscado.getAtencionMedica().getCita().getCodigo(),
                buscado.getMotivo(),
                buscado.getFechaInicio(),
                buscado.getFechaFin()
        );
    }

    private boolean estaPacienteActivo(Paciente paciente) {
        return paciente.getEstado() != EstadoUsuario.ACTIVO;
    }

}
