package mockito;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceVerifyTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Inject into service
        MyService service = new MyService(mockApi);

        // Step 3: Perform action
        service.fetchData();

        // Step 4: Verify interaction
        verify(mockApi).getData();
    }
}
