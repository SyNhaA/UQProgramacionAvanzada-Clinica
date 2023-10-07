package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.admin.ItemConsultaDTO;
import co.edu.uniquindio.uniclinic.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.uniclinic.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    @Override
    public List<ItemConsultaDTO> listarCitasPendientes(int codigoMedico) throws Exception {
        return null;
    }

    @Override
    public int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemConsultaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {
        return null;
    }

}
