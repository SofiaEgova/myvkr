package com.myvkr.vkr.rep;

import com.myvkr.vkr.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRep extends JpaRepository<Image, Long> {
}
