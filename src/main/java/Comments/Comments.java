package Comments;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comments {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
