package com.y3school.schedule.serviceImpl;

import com.y3school.schedule.entity.AuthorityTable;
import com.y3school.schedule.enums.ScheduleEnum;
import com.y3school.schedule.exceptions.ScheduleException;
import com.y3school.schedule.repository.AuthorityRepository;
import com.y3school.schedule.service.AuthorityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author TomShiDi
 * @Description
 * @Date 2019/8/17
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class AuthorityServiceImpl implements AuthorityService {

    private AuthorityRepository repository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuthorityTable findBySnameIdAndGnameId(String snameId, String gnameId) {
        AuthorityTable authorityTable = repository.findBySnameIdAndGnameId(snameId, gnameId);
        if (authorityTable == null) {
            throw new ScheduleException(ScheduleEnum.CANNOT_FIND_AUTHORITY_INFO);
        }
        return authorityTable;
    }

    @Override
    public List<AuthorityTable> findBySnameId(String snameId) {
        return repository.findBySnameId(snameId);
    }

    @Override
    public List<AuthorityTable> findByGnameId(String gnameId) {
        return repository.findByGnameId(gnameId);
    }

    @Override
    public AuthorityTable insertAuthority(AuthorityTable authorityTable) {
        AuthorityTable result = repository.findBySnameIdAndGnameId(authorityTable.getSnameId(),
                authorityTable.getGnameId());
        if (result != null) {
            throw new ScheduleException(ScheduleEnum.AUTHORITY_INFO_REPEAT);
        }
        return repository.save(authorityTable);
    }

    @Override
    public AuthorityTable updateAuthority(AuthorityTable authorityTable) {
        return null;
    }

    @Override
    public void deleteBySnameIdAndGnameId(String snameId, String gnameId) {
        repository.deleteBySnameIdAndGnameId(snameId, gnameId);
    }
}
