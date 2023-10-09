package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.pqrs.*;
import co.edu.uniquindio.uniclinic.modelo.entidades.Cuenta;
import co.edu.uniquindio.uniclinic.modelo.entidades.Mensaje;
import co.edu.uniquindio.uniclinic.modelo.entidades.Pqrs;
import co.edu.uniquindio.uniclinic.modelo.enums.EstadoPQRS;
import co.edu.uniquindio.uniclinic.repositorios.CuentaRepo;
import co.edu.uniquindio.uniclinic.repositorios.MensajeRepo;
import co.edu.uniquindio.uniclinic.repositorios.PQRSRepo;
import co.edu.uniquindio.uniclinic.servicios.interfaces.PQRSServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PQRSServicioImpl implements PQRSServicio {

    private final PQRSRepo pqrsRepo;
    private final MensajeRepo mensajeRepo;
    private final CuentaRepo cuentaRepo;

    @Override
    public List<ItemPQRSAdminDTO> listarPQRS() throws Exception {
        List<Pqrs> listaPqrs = pqrsRepo.findAll();
        List<ItemPQRSAdminDTO> respuesta = new ArrayList<>();

        for( Pqrs p: listaPqrs ) {
            respuesta.add( new ItemPQRSAdminDTO(
                    p.getCodigo(),
                    p.getCita().getPaciente().getNombre(),
                    p.getFechaCreacion(),
                    p.getEstado()
            ) );
        }

        return respuesta;
    }

    @Override
    public void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPQRS);

        if( opcional.isEmpty() ) {
            throw new Exception("No existe un PQRS con el código "+codigoPQRS);
        }

        Pqrs pqrs = opcional.get();
        pqrs.setEstado(estadoPQRS);

        pqrsRepo.save(pqrs);
    }

    @Override
    public List<ItemPQRSPacienteDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception {
        return 0;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigoPQRS) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPQRS);

        if(opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+codigoPQRS);
        }

        Pqrs buscado = opcional.get();
        List<Mensaje> mensajes = mensajeRepo.findAllByPqrsCodigo(codigoPQRS);

        return new DetallePQRSDTO(
                buscado.getCodigo(),
                buscado.getFechaCreacion(),
                buscado.getCita().getCodigo(),
                buscado.getCita().getPaciente().getNombre(),
                buscado.getCita().getMedico().getNombre(),
                buscado.getMotivo(),
                buscado.getEstado(),
                convertirRespuestasDTO(mensajes)
        );
    }

    private List<RespuestaDTO> convertirRespuestasDTO(List<Mensaje> mensajes) {
        return mensajes.stream().map(m -> new RespuestaDTO(
                m.getCodigo(),
                m.getCuenta().getCorreo(),
                m.getFechaCreacion(),
                m.getMensaje()
        )).toList();
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        Optional<Pqrs> opcionalPQRS = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());

        if(opcionalPQRS.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+registroRespuestaDTO.codigoPQRS());
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());

        if(opcionalCuenta.isEmpty()){
            throw new Exception("No existe una cuenta con el código "+registroRespuestaDTO.codigoCuenta());
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPqrs(opcionalPQRS.get());
        mensajeNuevo.setFechaCreacion(LocalDateTime.now());
        mensajeNuevo.setCuenta(opcionalCuenta.get());
        mensajeNuevo.setMensaje(registroRespuestaDTO.mensaje() );

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();
    }

}
