package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.admin.ItemConsultaDTO;
import co.edu.uniquindio.uniclinic.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.modelo.entidades.Medico;
import co.edu.uniquindio.uniclinic.modelo.enums.EstadoUsuario;
import co.edu.uniquindio.uniclinic.repositorios.MedicoRepo;
import co.edu.uniquindio.uniclinic.repositorios.PQRSRepo;
import co.edu.uniquindio.uniclinic.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    private final MedicoRepo medicoRepo;

    private final PQRSRepo pqrsRepo;

    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {
        return 0;
    }


    @Override
    public int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {

        Optional<Medico> opcional = medicoRepo.findById(medicoDTO.codigo());

        if( opcional.isEmpty()){
            throw new Exception("No existe un medico con el codigo" + medicoDTO.codigo());
        }

        Medico buscado = opcional.get();
        buscado.setCedula(medicoDTO.cedula());
        buscado.setTelefono(medicoDTO.telefono());
        buscado.setNombre(medicoDTO.nombre());
        buscado.setEspecialidad(medicoDTO.especialidad());
        buscado.setCiudad(medicoDTO.ciudad());
        buscado.setCorreo(medicoDTO.correo());

        medicoRepo.save(buscado);
        return 0;
    }

    @Override
    public void eliminarMedico(int codigo) throws Exception {
        Optional<Medico> opcional = medicoRepo.findById(codigo);
        if( opcional.isEmpty()){
            throw new Exception("No existe un medico con el código " + codigo);
        }

        Medico buscado = opcional.get();
        buscado.setEstado(EstadoUsuario.INACTIVO);

        medicoRepo.save( buscado );
    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {
        List<Medico> medicos = medicoRepo.findAll();

        if(medicos.isEmpty()){
            throw new Exception("No hay medicos");
        }

        List<ItemMedicoDTO> respuesta = medicos.stream().map( m -> new ItemMedicoDTO(
                m.getCodigo(),
                m.getCedula(),
                m.getNombre(),
                m.getUrlFoto(),
                m.getEspecialidad()
        )).toList();

        return null;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<ItemConsultaDTO> listarCitas() throws Exception {
        return null;
    }

}
