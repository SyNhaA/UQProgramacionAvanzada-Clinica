package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.autenticacion.NuevaPasswordDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.*;
import co.edu.uniquindio.uniclinic.excepciones.ResourceAlreadyExistsException;
import co.edu.uniquindio.uniclinic.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniclinic.modelo.entidades.Cita;
import co.edu.uniquindio.uniclinic.modelo.entidades.Medico;
import co.edu.uniquindio.uniclinic.modelo.entidades.Paciente;
import co.edu.uniquindio.uniclinic.modelo.enums.*;
import co.edu.uniquindio.uniclinic.repositorios.CitaRepo;
import co.edu.uniquindio.uniclinic.repositorios.PacienteRepo;
import co.edu.uniquindio.uniclinic.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;
    private final CitaRepo citaRepo;

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
    public int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception {
        return 0;
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
    public DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws Exception {
        return null;
    }

    @Override
    public DetalleRecetaDTO verDetalleRecetaMedica(int codigoReceta) throws Exception {
        return null;
    }

    @Override
    public DetalleIncapacidadDTO verDetalleIncapacidad(int codigoIncapacidad) throws Exception {
        return null;
    }

    private boolean estaPacienteActivo(Paciente paciente) {
        return paciente.getEstado() != EstadoUsuario.ACTIVO;
    }

    public Paciente pacienteIsActive(int codigoPaciente) {
        return pacienteRepo.isActive(codigoPaciente);
    }

    public Optional<Paciente> pacienteExiste(int codigoPaciente) {
        return pacienteRepo.findById(codigoPaciente);
    }

}
