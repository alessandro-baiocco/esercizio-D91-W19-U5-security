package application.U5D9.controllers;

import application.U5D9.entities.Blog;
import application.U5D9.entities.PostBlog;
import application.U5D9.exceptions.BadRequestException;
import application.U5D9.payloads.NewBlogPostDTO;
import application.U5D9.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;


    @GetMapping("")
    public Page<Blog> getAllBlog(@RequestParam(defaultValue = "0")int page ,
                                 @RequestParam(defaultValue = "10")int size){
        return blogService.getAllBlogs(page , size);
    }

    @GetMapping("/{id}")
    public Blog findById(@PathVariable int id){
        return blogService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlog(@RequestBody @Validated NewBlogPostDTO body, BindingResult validation ){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }else {
            try {
                return blogService.save(body);
            }catch (IOException e){
                throw new RuntimeException(e);
            }

        }

    }


    @PutMapping("/{id}")
    public Blog findByIdAndUpdate(@PathVariable int id, @RequestBody Blog body){
        return blogService.findByIdAndUpdate(id, body);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id){
        blogService.findByIdAndDelete(id);
    }


    @GetMapping("/coffee")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String cooffe(){
        return " client error response code indicates that the server refuses " +
                "to brew coffee because it is, permanently, a teapot. A" +
                " combined coffee/tea pot that is temporarily out of coffee";
    }


}
