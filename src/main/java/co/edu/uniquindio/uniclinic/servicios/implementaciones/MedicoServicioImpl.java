package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.admin.ItemConsultaDTO;
import co.edu.uniquindio.uniclinic.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.uniclinic.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.modelo.entidades.Cita;
import co.edu.uniquindio.uniclinic.modelo.entidades.DiaLibre;
import co.edu.uniquindio.uniclinic.modelo.entidades.Medico;
import co.edu.uniquindio.uniclinic.repositorios.MedicoRepo;
import co.edu.uniquindio.uniclinic.repositorios.PacienteRepo;
import co.edu.uniquindio.uniclinic.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final MedicoRepo medicoRepo;
    private final PacienteRepo pacienteRepo;
    private final PacienteServicioImpl pacienteServicio;

    @Override
    public List<ItemConsultaDTO> listarCitasPendientes(int codigoMedico) throws Exception {
        if (medicoExiste(codigoMedico).isEmpty()) {
            throw new Exception("No existe un medico con el código " + codigoMedico);
        }

        if (medicoIsActive(codigoMedico) == null) {
            throw new Exception("El medico no se encuentra " + codigoMedico);
        }

        List<ItemConsultaDTO> listaItemConsultaDTOS = new ArrayList<>();
        for (Cita cita : medicoRepo.listarCitasPendiente(codigoMedico)) {
            ItemConsultaDTO itemConsultaDTO = new ItemConsultaDTO(
                    cita.getMedico().getCodigo(),
                    cita.getPaciente().getNombre(),
                    cita.getFechaCita(),
                    cita.getMotivo(),
                    cita.getEstado()
            );
            listaItemConsultaDTOS.add(itemConsultaDTO);
        }

        return listaItemConsultaDTOS;
    }


    @Override
    public int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception {
        // Pendiente
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception {
        if (pacienteServicio.pacienteExiste(codigoPaciente).isEmpty()) {
            throw new Exception("No existe un paciente con ese codigo: " + codigoPaciente);
        }

        List<ItemCitaDTO> listaItemCitaDTO = new ArrayList<>();
        for (Cita cita : pacienteRepo.listarHistorialAtencionesPaciente(codigoPaciente)) {
            ItemCitaDTO itemCitaDTO = new ItemCitaDTO(
                    cita.getCodigo(),
                    cita.getMedico().getNombre(),
                    cita.getFechaCita(),
                    cita.getMotivo(),
                    cita.getEstado()
            );
            listaItemCitaDTO.add(itemCitaDTO);
        }
        return listaItemCitaDTO;
    }

    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO, int codigoMedico) throws Exception {
        if (medicoExiste(codigoMedico).isEmpty()) {
            throw new Exception("No existe un medico con el código " + codigoMedico);
        }

        if (medicoIsActive(codigoMedico) == null) {
            throw new Exception("El medico no se encuentra " + codigoMedico);
        }

        Optional<Medico> medico = medicoRepo.findById(codigoMedico);
        DiaLibre diaLibre = new DiaLibre();
        diaLibre.setDia(diaLibreDTO.dia());
        diaLibre.setMedico(medico.get());
        // PREGUNTA
        // No se si guardar el dia, o al guardar el medico se guarde el dia
        medico.get().getDiasLibres().add(diaLibre);
        Medico medico__ = medicoRepo.save(medico.get());

        if (medico__ == null) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<ItemConsultaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {
        if (medicoExiste(codigoMedico).isEmpty()) {
            throw new Exception("No existe un medico con el código " + codigoMedico);
        }

        if (medicoIsActive(codigoMedico) == null) {
            throw new Exception("El medico no se encuentra " + codigoMedico);
        }

        List<ItemConsultaDTO> listItemConsultaDTO = new ArrayList<>();

        ArrayList<ItemConsultaDTO> listaCitasMedico = new ArrayList<>();
        for (Cita cita : medicoRepo.listasCitas(codigoMedico)) {
            ItemConsultaDTO itemConsultaDTO = new ItemConsultaDTO(
                    cita.getMedico().getCodigo(),
                    cita.getPaciente().getNombre(),
                    cita.getFechaCita(),
                    cita.getMotivo(),
                    cita.getEstado()
            );
            listaCitasMedico.add(itemConsultaDTO);
        }

        return listItemConsultaDTO;
    }

    private Medico medicoIsActive(int codigoMedico) {
        return medicoRepo.isActive(codigoMedico);
    }

    private Optional<Medico> medicoExiste(int codigoMedico) {
        return medicoRepo.findById(codigoMedico);
    }

}
