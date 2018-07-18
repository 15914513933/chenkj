package com.chenkj.mapper;

import org.springframework.stereotype.Component;

import com.chenkj.model.FUploadRecord;
@Component
public interface FUploadRecordMapper {
	boolean saveUploadRecord(FUploadRecord f);
}
