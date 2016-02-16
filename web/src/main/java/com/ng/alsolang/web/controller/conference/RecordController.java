package com.ng.alsolang.web.controller.conference;

import com.ng.alsolang.domain.conference.Recordings;
import com.ng.alsolang.domain.util.JaxbUtil;
import com.ng.alsolang.rpc.conference.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 录像控制类
 * User: zhangxuegang
 * Date: 2016/1/31
 * Time: 12:47
 */
@Controller
@RequestMapping("/record")
public class RecordController {

    private static final Logger logger = LoggerFactory.getLogger(RecordController.class);

    @Resource(name = "recordServiceImpl")
    private RecordService recordService;

    /**
     * 获取所有录像
     *
     * @return
     */

    @RequestMapping(value = "/getRecordings.do")
    public String getRecordings(HttpServletRequest request, Model model) {
        JaxbUtil resultBinder = new JaxbUtil(Recordings.class, JaxbUtil.CollectionWrapper.class);
        // 会议ID
        String meetingID = request.getParameter("meetingID");
        String retXml = recordService.getRecordings(meetingID);
        Recordings recordings = resultBinder.fromXml(retXml);
        model.addAttribute("recordings", recordings);
        return "conference/getRecordings";
    }

}
