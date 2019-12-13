package life.zfq.community.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.zfq.community.community.dao.Question;
import life.zfq.community.community.dao.User;
import life.zfq.community.community.dto.PageInfoDto;
import life.zfq.community.community.dto.QuestionDto;
import life.zfq.community.community.mapper.QuestionMapper;
import life.zfq.community.community.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouFaQuan
 * @Date: 2019/12/11 11:34
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    public PageInfoDto list(Integer page, Integer size) {
        Integer totalCount = questionMapper.count();
        PageInfoDto pageInfoDto = new PageInfoDto();
        pageInfoDto.setPagination(totalCount,page,size);
        if (page < 1) {
            page = 1;
        }
        if (page > pageInfoDto.getTotalPage()) {
            page = pageInfoDto.getTotalPage();
        }
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDto> questionDtos = new ArrayList<>();

         for(Question question:questions){
             User user = userMapper.findById(question.getCreator());
             QuestionDto questionDto = new QuestionDto();
             BeanUtils.copyProperties(question, questionDto);
             questionDto.setUser(user);
             questionDtos.add(questionDto);
         }
         pageInfoDto.setQuestions(questionDtos);
         return  pageInfoDto;

    }
}
