package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.admin.ItemConsultaDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.dto.medico.*;

import java.util.List;

public interface MedicoServicio {

    List<ItemConsultaDTO> listarCitasPendientes(int codigoMedico) throws Exception;

    int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception;

    List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception;

    int agendarDiaLibre(DiaLibreDTO diaLibreDTO, int codigoMedico) throws Exception;

    List<ItemConsultaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;

}
