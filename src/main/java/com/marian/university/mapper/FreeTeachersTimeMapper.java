package com.marian.university.mapper;

import com.marian.university.dto.FreeTeachersTimeDTO;
import com.marian.university.entity.FreeTeachersTime;
import com.marian.university.entity.TeacherDetail;
import com.marian.university.payload.responce.MessageResponse;
import com.marian.university.repository.FreeTeachersTimeRepository;
import com.marian.university.repository.TeacherDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sound.midi.Soundbank;

public class FreeTeachersTimeMapper {

    @Autowired
    private FreeTeachersTimeRepository freeTeachersTimeRepository;

    @Autowired
    private TeacherDetailRepository teacherDetailRepository;

    public FreeTeachersTimeDTO  freeTeachersTimeToDto(FreeTeachersTime freeTeachersTime){
        FreeTeachersTimeDTO dto = new FreeTeachersTimeDTO();
        dto.setId(freeTeachersTime.getId());
        dto.setDatestart(freeTeachersTime.getDatestart());
        dto.setTimeStart(freeTeachersTime.getTimeStart());
        dto.setDateend(freeTeachersTime.getDateend());
        dto.setTimeend(freeTeachersTime.getTimeend());
        System.out.println("+++"+ freeTeachersTime.getId());
        int id  =  freeTeachersTime.getId();
        System.out.println("id" + id);
//        FreeTeachersTime teacherDetail = freeTeachersTimeRepository.getOne(id);//.getTeacherDetail();
//        System.out.println("===="+teacherDetail.getId());
        dto.setTeacherDetailsId(2); // переробити
        return dto;
    }
    public FreeTeachersTime dtoToFreeTeachersTime(FreeTeachersTimeDTO dto){
        FreeTeachersTime time = new FreeTeachersTime();
        time.setId(dto.getId());
        time.setDatestart(dto.getDatestart());
        time.setDateend(dto.getDateend());
        time.setTimeStart(dto.getTimeStart());
        time.setTimeend(dto.getTimeend());
//        time.setTeacherDetail(teacherDetailRepository.getOne(dto.getTeacherDetailsId()));
        return time;
    }

}
