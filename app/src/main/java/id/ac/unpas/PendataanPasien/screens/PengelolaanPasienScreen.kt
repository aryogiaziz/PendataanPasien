package id.ac.unpas.PendataanPasien.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.unpas.PendataanPasien.model.DataPasien
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun PengelolaanPasienScreen() {
    val _list = remember { MutableStateFlow(listOf<DataPasien>()) }
    val list by remember { _list }.collectAsState()
    Column(modifier = Modifier.fillMaxWidth()) {
        FormPencatatanPasien { item ->
            val newList = ArrayList(list)
            newList.add(item)
            _list.value = newList
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = list, itemContent = { item ->
                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Kode Pasien", fontSize = 14.sp)
                        Text(text = item.kodepasien, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tanggal", fontSize = 14.sp)
                        Text(text = item.tanggal, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Nama", fontSize = 14.sp)
                        Text(text = item.nama, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Jenis Kelamin", fontSize = 14.sp)
                        Text(text = item.jeniskelamin, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Keluhan", fontSize = 14.sp)
                        Text(text = item.keluhan, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }
                Divider(modifier = Modifier.fillMaxWidth())
            })
        }
    }
}