package com.shuai.test.fileUpload;

import com.shuai.test.fileUpload.storage.StorageFileNotFoundException;
import com.shuai.test.fileUpload.storage.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.*;
@Controller
public class FileUploadController {

    private final StorageService storageService;

    public FileUploadController(StorageService storage) {
        this.storageService = storage;
    }


    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        Stream<Path> stream = storageService.loadAll();
        //MvcUriComponensBuilder => calculate an uri to the actual resource
        List<String> ls = stream.map(
                path -> MvcUriComponentsBuilder.fromMethodName(
                        FileUploadController.class,
                        "serveFile",
                        path.getFileName().toString())
                            .build()
                            .toUri()
                            .toString()
        ).collect(Collectors.toList());
        model.addAttribute("files");

        model.addAttribute("files", ls);
        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }


}
