package application.U5D9.controllers;


import application.U5D9.entities.Blog;
import application.U5D9.entities.User;
import application.U5D9.exceptions.BadRequestException;
import application.U5D9.payloads.NewUserDTO;
import application.U5D9.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersService usersService;


    @GetMapping("")
    public Page<User> getAllUser(@RequestParam(defaultValue = "0")int page ,
                                 @RequestParam(defaultValue = "10")int size,
                                 @RequestParam(defaultValue = "id")String order){
        return usersService.getAllUser(page , size , order);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id){
        return usersService.findById(id);
    }





    @PutMapping("/{id}")
    public User findByIdAndUpdate(@PathVariable int id, @RequestBody User body){
        return usersService.findByIdAndUpdate(id, body);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id){
        usersService.findByIdAndDelete(id);
    }



    @GetMapping("/coffee")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String cooffe(){
        return " client error response code indicates that the server refuses " +
                "to brew coffee because it is, permanently, a teapot. A" +
                " combined coffee/tea pot that is temporarily out of coffee";
    }


    @GetMapping("/{id}/blogs")
    public List<Blog> getUserBlog(@PathVariable int id){
        return usersService.getUserBlog(id);
    }

    @PostMapping("/{id}/upload")
    public User changeUserImg(@PathVariable int id , @RequestParam("avatar")  MultipartFile body) throws IOException{
        return usersService.uploadPicture(id, body);

    }







}
