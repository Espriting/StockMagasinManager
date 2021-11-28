package tn.magasin.stock.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.magasin.stock.Service.UserService;
import tn.magasin.stock.entity.Role;
import tn.magasin.stock.entity.User;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Api(tags = "User Manager")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService us;


    public UserController(UserService us) {
        this.us = us;
    }

   /* @GetMapping("/getAllUsers")
    public List<User> getUsers(){
        return us.chercherUser();
    }*/

    @GetMapping("/deletUser/{id}")
    @ApiOperation(value = "Delete User By Id ")
    public List<User> deletUser(@PathVariable(value = "id") long id) {
        us.supprimerUser(id);
        return us.chercherUser();
    }


    @PostMapping("/registerUser")
    @ApiOperation(value = "Add User By Id ")
    public String RegisterUser(@RequestBody User User) {
        us.ajouterUser(User);
        return "Hi " + User.getNom() + " your registration process successfuly Done";
    }

    @GetMapping("/getUserByEmail/{email}")
    @ApiOperation(value = "Get User By Email ")
    public User getUserByEmail(@PathVariable(value = "email") String email) {
        return us.getUserByEmail(email);
    }

    @PostMapping("/updateUser/{id}")
    @ApiOperation(value = "Update User ")
    public String UpdateUser(@RequestBody User User, @PathVariable long id) {
        us.updateUser(User, id);
        return "User updated successfuly Don !!";
    }

    @GetMapping("/DeleteAllUsers")
    @ApiOperation(value = "Delete All Users ")
    public String DeleteAllUsers() {
        us.supprimerToutLesUsers();
        return "All Users deleted !";
    }

    @PostMapping("/login")
    @ApiOperation(value = "Login ")
    public User login(@RequestBody User User) throws Exception {
        String email = User.getEmail();
        String password = User.getPassword();
        User cl = null;
        if (email != null && password != null) cl = us.doLogin(email, password);

        if (cl == null) throw new Exception("No Account to connect !");


        return cl;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(us.chercherUser());
    }

    @PostMapping("/users/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(us.ajouterUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(us.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        us.addRoleToUser(form.getNom(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getUserById/{id}")
    @ApiOperation(value = "Get User By id ")
    public User getUserById(@PathVariable(value = "id") Long id) {
        return us.getUserById(id);
    }
}

@Data
class RoleToUserForm {
    private String nom;
    private String roleName;
}