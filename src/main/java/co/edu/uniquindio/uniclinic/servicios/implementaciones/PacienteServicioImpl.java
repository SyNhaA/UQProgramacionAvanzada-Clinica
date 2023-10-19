package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.autenticacion.NuevaPasswordDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.*;
import co.edu.uniquindio.uniclinic.modelo.entidades.Paciente;
import co.edu.uniquindio.uniclinic.repositorios.PacienteRepo;
import co.edu.uniquindio.uniclinic.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;
    @Override
    public int registrarse(RegistroPacienteDTO pacienteDTO) throws Exception {
        return 0;
    }

    @Override
    public int editarPerfil(InfoPacienteDTO infoPacienteDTO) throws Exception {
        return 0;
    }

    @Override
    public void eliminarCuenta(int codigo) throws Exception {

    }

    @Override
    public InfoPacienteDTO verDetallePaciente(int codigo) throws Exception {
        return null;
    }

    @Override
    public int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {
        return null;
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

    public Paciente pacienteIsActive(int codigoPaciente) {
        return pacienteRepo.isActive(codigoPaciente);
    }

    public Optional<Paciente> pacienteExiste(int codigoPaciente) {
        return pacienteRepo.findById(codigoPaciente);
    }

}
