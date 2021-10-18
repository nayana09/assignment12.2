import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import issuepojo.Fields;
import issuepojo.IssueType;
import issuepojo.PayloadIssue;
import issuepojo.Project;

public class CreateIssue {
    public static void main(String[] args) {
        IssueType type = new IssueType("Bug");
        Project project = new Project("Test");
        Fields fields = new Fields("REST ye merry gentlemen.",
                "Creating of an issue using project keys and issue",
        type,project);
        PayloadIssue payloadIssue = new PayloadIssue(fields);

        /*ObjectMapper mapper = new ObjectMapper();
        String p = mapper.WriterWithDefaultPrettyPrint().writeValuesAsString(payloadPojo);
        System.out.println(p);*/
        }
    }
}
