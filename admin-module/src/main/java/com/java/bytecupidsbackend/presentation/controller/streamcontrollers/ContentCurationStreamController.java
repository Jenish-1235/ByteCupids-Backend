package com.java.bytecupidsbackend.presentation.controller.streamcontrollers;

import com.java.bytecupidsbackend.agentorchestration.Manager;
import com.java.bytecupidsbackend.presentation.dto.ContentCurationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bytecupids/admin/generate")
public class ContentCurationStreamController {

    private final Manager manager;

    public ContentCurationStreamController(Manager manager) {
        this.manager = manager;
    }

    private final String academicAgentKey = "academic-agent";
    private final String practicalAgentKey = "practical-agent";
    private final String validatorAgentKey = "validator-agent";

    @PostMapping("/curate-content")
    public void curateContent(@RequestBody ContentCurationRequest request) {
        String accessToken = request.getAccessToken();
        String moduleId = request.getModuleId();

//        TODO : Implement access token validation logic here


/*        TODO :

                1. Given the module Id, fetch the topic list from the database.
                2. Use the topic list to generate a prompt for the academic agent.
                3. Use the topic list to generate a prompt for the practical agent.
                4. Use the topic list to generate a prompt for the validator agent.
                5. Use this prompts to generate the content and store it in the database along with the module Id, topic id , subtopic id and the content.
                6. Use threadpool to run the above steps in parallel for multiple topics together.

 */


        String prompt = "module-id: " + moduleId;

        // Use the manager to curate content based on the access token and module ID
        String academicResponse = manager.getResponse(prompt , academicAgentKey);
        String practicalResponse = manager.getResponse(prompt , practicalAgentKey);
        String curatedContent = manager.getResponse(prompt , validatorAgentKey);



        // Return or process the curated content as needed
        System.out.println("Curated Content: " + curatedContent);
    }


}
