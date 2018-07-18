package com.chenkj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenkj.mapper.FUploadRecordMapper;
import com.chenkj.model.FUploadRecord;
@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	private FUploadRecordMapper fUploadRecordMapper;
	
	@Override
	public boolean saveUploadRecord(FUploadRecord f) {
		return fUploadRecordMapper.saveUploadRecord(f);
	}

}
