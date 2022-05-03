package peaksoft.crudlms_security.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.crudlms_security.model.Group;
import peaksoft.crudlms_security.repository.GroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;

    public List<Group> getAllGroups(){
        return repository.findAll();
    }

    public Group getGroupById(long id){
        return repository.findById(id).get();
    }

    public void saveGroup(Group group){
        repository.save(group);
    }
    public void deleteGroup(long id){
        repository.deleteById(id);
    }
}
