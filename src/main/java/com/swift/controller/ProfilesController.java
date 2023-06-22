package com.swift.controller;

import com.swift.model.ModelResponse;
import com.swift.model.Profile;
import com.swift.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/profiles/v1")
public class ProfilesController {

    private final ProfileService profileService;

    @Autowired
    public ProfilesController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/save")
    public ModelResponse save(@RequestBody Profile profile) {
        try {
            profileService.save(profile);
            return new ModelResponse()
                    .withHttpStatusCode(HttpStatus.CREATED);


        } catch (Exception e) {
            return new ModelResponse()
                    .withHttpStatusCode(HttpStatus.NOT_MODIFIED)
                    .withMessage(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ModelResponse update(@RequestParam Long id, @RequestBody Profile profile) {
        try {
            profileService.update(id, profile);
            return new ModelResponse()
                    .withHttpStatusCode(HttpStatus.OK);


        } catch (Exception e) {
            return new ModelResponse()
                    .withHttpStatusCode(HttpStatus.NOT_MODIFIED)
                    .withMessage(e.getMessage());
        }
    }

    @GetMapping(value = "/get")
    public ModelResponse get(@RequestParam Long id) {
        try {

            return new ModelResponse()
                    .withHttpStatusCode(HttpStatus.OK)
                    .withBody(profileService.get(id));


        } catch (Exception e) {
            return new ModelResponse()
                    .withHttpStatusCode(HttpStatus.NOT_FOUND)
                    .withMessage(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ModelResponse getAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size) {
        try {

            return new ModelResponse()
                    .withHttpStatusCode(HttpStatus.OK)
                    .withBody(profileService.getAll(PageRequest.of(page, size)));


        } catch (Exception e) {
            return new ModelResponse()
                    .withHttpStatusCode(HttpStatus.NOT_FOUND)
                    .withMessage(e.getMessage());
        }
    }

}
