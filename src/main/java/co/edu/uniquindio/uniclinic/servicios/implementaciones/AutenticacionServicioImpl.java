package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.autenticacion.LoginDTO;
import co.edu.uniquindio.uniclinic.dto.autenticacion.NuevaPasswordDTO;
import co.edu.uniquindio.uniclinic.dto.autenticacion.TokenDTO;
import co.edu.uniquindio.uniclinic.modelo.entidades.Cuenta;
import co.edu.uniquindio.uniclinic.modelo.entidades.Medico;
import co.edu.uniquindio.uniclinic.modelo.entidades.Paciente;
import co.edu.uniquindio.uniclinic.repositorios.CuentaRepo;
import co.edu.uniquindio.uniclinic.servicios.interfaces.AutenticacionServicio;
import co.edu.uniquindio.uniclinic.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {

    private final CuentaRepo cuentaRepo;
    private final JWTUtils jwtUtils;

    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByCorreo(loginDTO.correo());

        if(cuentaOptional.isEmpty()){
            throw new Exception("No existe el correo ingresado");
        }

        Cuenta cuenta = cuentaOptional.get();

        if(!passwordEncoder.matches(loginDTO.contrasenia(), cuenta.getContrasenia())){
            throw new Exception("La contraseña ingresada es incorrecta");
        }

        return new TokenDTO(crearToken(cuenta));
    }

    private String crearToken(Cuenta cuenta){
        String rol;
        String nombre;
        if(cuenta instanceof Paciente) {
            rol = "paciente";
            nombre = ((Paciente) cuenta).getNombre();
        } else if(cuenta instanceof Medico) {
            rol = "medico";
            nombre = ((Medico) cuenta).getNombre();
        } else {
            rol = "admin";
            nombre = "Administrador";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", cuenta.getCodigo());

        return jwtUtils.generarToken(cuenta.getCorreo(), map);
    }

    @Override
    public void enviarLinkRecuperacion(String correo) throws Exception {

    }

    @Override
    public int cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {
        Optional<Cuenta> cuenta = cuentaRepo.findByCorreo(nuevaPasswordDTO.email());
        if (cuenta.isEmpty()){
            throw new Exception("No hay una cuenta registrada con este correo");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(nuevaPasswordDTO.passwordNueva());

        cuenta.get().setContrasenia(passwordEncriptada);
        cuentaRepo.save(cuenta.get());
        return 0;
    }

}
