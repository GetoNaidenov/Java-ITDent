package bg.softuni.ITDent.service.impl;

import bg.softuni.ITDent.model.entities.ForumEntity;
import bg.softuni.ITDent.model.service.ForumCreateServiceModel;
import bg.softuni.ITDent.model.view.ForumCommentViewModel;
import bg.softuni.ITDent.model.view.ForumViewModel;
import bg.softuni.ITDent.repository.ForumRepository;
import bg.softuni.ITDent.service.ForumService;
import bg.softuni.ITDent.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ForumServiceImpl implements ForumService {

    private final ModelMapper modelMapper;
    private final ForumRepository forumRepository;
    private final UserService userService;

    public ForumServiceImpl(ModelMapper modelMapper, ForumRepository forumRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.forumRepository = forumRepository;
        this.userService = userService;
    }

    @Override
    public List<ForumViewModel> findAll() {
        return forumRepository.findAll().stream()
                .map(f ->{
                    ForumViewModel fvm = modelMapper.map(f,ForumViewModel.class);
                    fvm.setCreator(f.getCreator().getUsername());
                    return fvm;
                        }).collect(Collectors.toList());

    }

    @Override
    public void saveForum(ForumCreateServiceModel forumCreateServiceModel) {

        ForumEntity forumEntity = modelMapper.map(forumCreateServiceModel,ForumEntity.class);
        forumEntity.setCreator(userService.findByUserName(forumCreateServiceModel.getCreator()));

        forumRepository.save(forumEntity);
    }

    @Override
    public boolean nameExist(String name) {
        return forumRepository.findByName(name).isPresent();
    }

    @Override
    public ForumViewModel findById(Long id) {
        ForumEntity forum = forumRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("forum not found"));

        ForumViewModel forumViewModel = modelMapper.map(forum,ForumViewModel.class);

        forumViewModel.setCreator(forum.getCreator().getUsername());
        return forumViewModel;
    }

    @Override
    public Optional<ForumEntity> findByName(String forum) {
        return forumRepository.findByName(forum);
    }

    @Override
    public Long forumCount() {
        return forumRepository.count();
    }


}
