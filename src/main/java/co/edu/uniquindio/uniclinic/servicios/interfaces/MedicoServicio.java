package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.dto.medico.*;

import java.util.List;

public interface MedicoServicio {

    List<ItemCitaDTO> listarCitasPendientes(int codigoMedico) throws Exception;

    int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception;

    List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception;

    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;

    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;

}
