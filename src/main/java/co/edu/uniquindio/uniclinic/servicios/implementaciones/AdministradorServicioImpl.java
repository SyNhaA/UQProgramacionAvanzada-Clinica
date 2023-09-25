package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.repositorios.MedicoRepo;
import co.edu.uniquindio.uniclinic.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    private final MedicoRepo medicoRepo;

    @Override
    public int crearMedico(RegistroMedicoDTO medico) throws Exception {
        return 0;
    }

    @Override
    public int actualizarMedico(int codigo, RegistroMedicoDTO medico) throws Exception {
        return 0;
    }

    @Override
    public void eliminarMedico(int codigo) throws Exception {

    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {
        return null;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<ItemCitaDTO> listarCitas() throws Exception {
        return null;
    }
}
