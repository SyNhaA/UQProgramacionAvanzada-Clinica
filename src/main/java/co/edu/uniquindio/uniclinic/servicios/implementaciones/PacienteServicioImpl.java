package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.paciente.*;
import co.edu.uniquindio.uniclinic.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    @Override
    public int registrarse(RegistroPacienteDTO pacienteDTO) throws Exception {
        return 0;
    }

    @Override
    public int editarPerfil(DetallePacienteDTO detallePacienteDTO) throws Exception {
        return 0;
    }

    @Override
    public void eliminarCuenta(int codigo) throws Exception {

    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception {
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

}
