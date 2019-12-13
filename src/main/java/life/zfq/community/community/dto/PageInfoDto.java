package life.zfq.community.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouFaQuan
 * @Date: 2019/12/12 16:04
 */
@Data
public class PageInfoDto {
    private List<QuestionDto> questions;
    private boolean showFirstPage;
    private boolean showPrevious;
    private boolean showNext;
    private boolean showEndPage;
    //当前页
    private Integer page;
    //当前页码数
    private List<Integer> pages = new ArrayList<>();
    //    总页数
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page,Integer size) {
        this.page=page;

        if(totalCount % size == 0){
            totalPage = totalCount/size;
        } else {
            totalPage = totalCount/size+1;
        }


        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        // 是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        // 是否展示下一页
        if (page.equals(totalPage)) {
            showNext = false;
        } else {
            showNext = true;
        }

        // 是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        // 是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
