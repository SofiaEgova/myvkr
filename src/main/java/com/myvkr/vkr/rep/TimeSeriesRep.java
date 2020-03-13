package com.myvkr.vkr.rep;

import com.myvkr.vkr.model.Image;
import com.myvkr.vkr.model.TimeSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSeriesRep extends JpaRepository<TimeSeries, Long> {
}
