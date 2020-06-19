package com.anime.streamingserver.service.video;


import org.springframework.stereotype.Service;


// TODO : 파일 업로드 및 비디오 정보 업로드 할때, 데이터베이스 트랜잭션 대신 TCC(Try Confirm Cancel) 기법 적용하기

@Service
public class VideoService {

}


/*
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/post/{id}/uploadFile")
    public UploadFileResponseDTO uploadFile(@PathVariable Long id, @RequestParam("file") MultipartFile file){
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/post")
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        UploadFile uploadFile = new UploadFile();
        uploadFile.setFileName(fileName);
        uploadFile.setFileDownloadUri(fileDownloadUri);
        uploadFile.setFileType(file.getContentType());
        uploadFile.setSize(file.getSize());

        Post post = new Post();
        post.setId(id);

        uploadFile.setPost(post);

        uploadFileInfoRepository.save(uploadFile);

        return new UploadFileResponseDTO(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/post/{id}/uploadMultipleFiles")
    public List<UploadFileResponseDTO> uploadMultipleFiles(@PathVariable Long id, @RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(id, file))
                .collect(Collectors.toList());
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/post/{id}/uploadMultipleFiles")
    public List<UploadFileResponseDTO> uploadMultipleFiles(@PathVariable Long id, @RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(id, file))
                .collect(Collectors.toList());
    }
* */