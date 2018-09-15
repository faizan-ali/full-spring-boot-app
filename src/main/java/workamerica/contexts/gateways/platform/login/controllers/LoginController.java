package workamerica.contexts.gateways.platform.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import workamerica.contexts.gateways.platform.login.components.LoginComponent;
import workamerica.contexts.gateways.platform.login.models.LoginRequest;
import workamerica.contexts.gateways.platform.login.models.LoginResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Faizan on 8/17/2016.
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginComponent component;

    @RequestMapping(method = RequestMethod.POST)
    public LoginResponse login (@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        return component.login(loginRequest, request);
    }

}
