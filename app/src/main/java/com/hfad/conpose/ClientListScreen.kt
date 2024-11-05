import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hfad.conpose.Client

@Composable
fun ClientListScreen(clients: List<Client>, onClientClick: (Client) -> Unit) {
    LazyColumn {
        items(clients) { client ->
            ListItem(
                modifier = Modifier.clickable { onClientClick(client) },
                headlineContent = { Text(client.name) }
            )
        }
    }
}