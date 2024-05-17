package com.mshistorial.mshistorial.Bl;

import jakarta.persistence.criteria.CriteriaBuilder;

public class MultipartFileDto {
    private Integer idMultimedia;
    private String name;
    private String originalFilename;
    private String contentType;
    private long size;
    private byte[] bytes; // Agregamos un campo para los bytes del archivo

    // Constructores, getters y setters
    public MultipartFileDto(Integer idMultimedia, String name, String originalFilename, String contentType, long size, byte[] bytes) {
        this.idMultimedia = idMultimedia;
        this.name = name;
        this.originalFilename = originalFilename;
        this.contentType = contentType;
        this.size = size;
        this.bytes = bytes;
    }

    public Integer getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
