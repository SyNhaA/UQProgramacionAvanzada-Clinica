package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.admin.ItemConsultaDTO;
import co.edu.uniquindio.uniclinic.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.uniclinic.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.modelo.entidades.Cita;
import co.edu.uniquindio.uniclinic.modelo.entidades.DiaLibre;
import co.edu.uniquindio.uniclinic.modelo.entidades.Medico;
import co.edu.uniquindio.uniclinic.repositorios.DiaLibreRepo;
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
    private final DiaLibreRepo diaLibreRepo;


    @Override
    public List<ItemConsultaDTO> listarCitasPendientes(int codigoMedico) throws Exception {
        if (medicoExiste(codigoMedico).isEmpty()) {
            throw new Exception("No existe un medico con el código " + codigoMedico);
        }

        if (medicoItsActive(codigoMedico) == null) {
            throw new Exception("El medico no se encuentra " + codigoMedico);
        }

        List<ItemConsultaDTO> listaItemConsultaDTOS = new ArrayList<>();
        for (Cita c : medicoRepo.listarCitasPendiente(codigoMedico)) {
            ItemConsultaDTO itemConsultaDTO = new ItemConsultaDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getFechaCita(),
                    c.getMotivo()
            );
            listaItemConsultaDTOS.add(itemConsultaDTO);
        }

        return listaItemConsultaDTOS;
    }

    @Override
    public int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception {
        if (pacienteServicio.pacienteExiste(codigoPaciente).isEmpty()) {
            throw new Exception("No existe un paciente con ese codigo: " + codigoPaciente);
        }

        List<ItemCitaDTO> listaItemCitaDTO = new ArrayList<>();
        for (Cita c : pacienteRepo.listarHistorialAtencionesPaciente(codigoPaciente)) {
            ItemCitaDTO itemCitaDTO = new ItemCitaDTO(
                    c.getCodigo(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad(),
                    c.getFechaCita(),
                    c.getMotivo()
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

        if (medicoItsActive(codigoMedico) == null) {
            throw new Exception("El medico no se encuentra " + codigoMedico);
        }

        Optional<Medico> medico = medicoRepo.findById(codigoMedico);
        DiaLibre diaLibre = new DiaLibre();
        if (medico.isPresent()) {
            diaLibre.setFecha(diaLibreDTO.fecha());
            diaLibre.setMedico(medico.get());
        }


        try {
            diaLibreRepo.save(diaLibre);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<ItemConsultaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {
        if (medicoExiste(codigoMedico).isEmpty()) {
            throw new Exception("No existe un medico con el código " + codigoMedico);
        }

        if (medicoItsActive(codigoMedico) == null) {
            throw new Exception("El medico no se encuentra " + codigoMedico);
        }

        ArrayList<ItemConsultaDTO> listaCitasMedico = new ArrayList<>();
        for (Cita c : medicoRepo.listasCitas(codigoMedico)) {
            ItemConsultaDTO itemConsultaDTO = new ItemConsultaDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getFechaCita(),
                    c.getMotivo()
            );
            listaCitasMedico.add(itemConsultaDTO);
        }

        return listaCitasMedico;
    }

    private Medico medicoItsActive(int codigoMedico) {
        return medicoRepo.findActivo(codigoMedico);
    }

    private Optional<Medico> medicoExiste(int codigoMedico) {
        return medicoRepo.findById(codigoMedico);
    }

}
