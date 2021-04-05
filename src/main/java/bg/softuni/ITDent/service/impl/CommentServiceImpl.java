package bg.softuni.ITDent.service.impl;

import bg.softuni.ITDent.model.entities.ClinicEntity;
import bg.softuni.ITDent.model.entities.CommentEntity;
import bg.softuni.ITDent.model.entities.UserEntity;
import bg.softuni.ITDent.model.service.CommentServiceModel;
import bg.softuni.ITDent.repository.CommentRepository;
import bg.softuni.ITDent.service.ClinicService;
import bg.softuni.ITDent.service.CommentService;
import bg.softuni.ITDent.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final ModelMapper modelMapper;
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ClinicService clinicService;


    public CommentServiceImpl(ModelMapper modelMapper, CommentRepository commentRepository, UserService userService, ClinicService clinicService) {
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.clinicService = clinicService;
    }


    @Override
    public void addComment(CommentServiceModel commentModel) {

        CommentEntity commentEntity = modelMapper.map(commentModel,CommentEntity.class);
        UserEntity creator = userService.findByUserName(commentModel.getUser());
        ClinicEntity clinic = clinicService.findByName(commentModel.getClinic()).orElseThrow(
                () -> new IllegalArgumentException("Clinic not found")
        );

        commentEntity.setClinic(clinic);
        commentEntity.setUser(creator);
        commentEntity.setReleaseData(LocalDateTime.now());

        commentRepository.save(commentEntity);

    }

    @Override
    public List<CommentEntity> findAllByClinic(Long id) {

        ClinicEntity clinic = modelMapper.map(clinicService.findById(id),ClinicEntity.class);

        return commentRepository.findAllByClinic(clinic);
    }
}
