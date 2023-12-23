package com.example.fealumniconnect.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.*

import com.example.fealumniconnect.R
import com.example.fealumniconnect.navigation.Screens
import com.example.fealumniconnect.ui.theme.PrimaryColor

data class Event(val date: String, val title: String, val participants: List<String>)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventScreen(navController: NavController) {

    var events by remember { mutableStateOf(emptyList<Event>()) }
    var showAddParticipantDialog by remember { mutableStateOf(false) }
    var selectedEventIndex by remember { mutableStateOf(-1) }
    var newParticipantName by remember { mutableStateOf("") }

    var eventTitle by remember { mutableStateOf("") }
    var eventDateTime by remember { mutableStateOf(Calendar.getInstance()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Acara Baru",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .align(Alignment.End)

        )

        OutlinedTextField(
            value = eventTitle,
            onValueChange = { eventTitle = it },
            label = { Text("Judul Acara") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Icon(
                Icons.Outlined.DateRange,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Tanggal: ${eventDateTime.get(Calendar.DAY_OF_MONTH)}/${
                    eventDateTime.get(
                        Calendar.MONTH
                    ) + 1
                }/${eventDateTime.get(Calendar.YEAR)}",
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = {
                    // TODO: Tampilkan date picker
                }
            ) {
                Icon(Icons.Outlined.DateRange, contentDescription = null)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Icon(
                Icons.Outlined.Menu,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Jam: ${eventDateTime.get(Calendar.HOUR_OF_DAY)}:${eventDateTime.get(Calendar.MINUTE)}",
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = {
                    // TODO: Tampilkan time picker
                }
            ) {
                Icon(Icons.Outlined.Menu, contentDescription = null)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Icon(
                Icons.Outlined.Add,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Tambah Peserta")
            EventList(
                events = events,
                onEventClick = { index ->
                    selectedEventIndex = index
                    showAddParticipantDialog = true
                }
            )

            // Floating Action Button to add a new event
            FloatingActionButton(
                onClick = {
                    events = events + Event("2023-12-31", "Presentation Alumni Connect", emptyList())
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Event")
            }

            // Dialog to add a participant to an event
            if (showAddParticipantDialog) {
                AddParticipantDialog(
                    onDismiss = { showAddParticipantDialog = false },
                    onAddParticipant = { participantName ->
                        if (selectedEventIndex != -1) {
                            val updatedEvents = events.toMutableList()
                            val updatedParticipants =
                                updatedEvents[selectedEventIndex].participants.toMutableList()
                            updatedParticipants.add(participantName)
                            updatedEvents[selectedEventIndex] =
                                updatedEvents[selectedEventIndex].copy(participants = updatedParticipants)
                            events = updatedEvents
                        }
                        showAddParticipantDialog = false
                    }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Icon(
                Icons.Outlined.LocationOn,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Ambil Lokasi")
            IconButton(
                onClick = {
                    // TODO: Ambil lokasi dengan GPS
                }
            ) {
                Icon(Icons.Outlined.LocationOn, contentDescription = null)
            }
        }

        var eventDescription = ""
        TextField(
            value = eventDescription,
            onValueChange = { eventDescription = eventDescription },
            label = { Text("Description here...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Button(
                onClick = {
                    // TODO: Implementasi untuk menyimpan event
                    navController.navigate(Screens.HomeScreen.name)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text("Selesai")
            }

            Button(
                onClick = {
                    // TODO: Implementasi untuk membatalkan event
                    navController.navigate(Screens.CalendarScreen.name)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text("Batal")
            }
        }
    }
}

@Composable
fun EventList(events: List<Event>, onEventClick: (Int) -> Unit) {
    LazyColumn {
        items(events.size) { index ->
            EventItem(
                event = events[index],
                onEventClick = { onEventClick(index) }
            )
        }
    }
}

@Composable
fun EventItem(event: Event, onEventClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onEventClick() }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "Date: ${event.date}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Title: ${event.title}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Participants: ${event.participants.joinToString(", ")}")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddParticipantDialog(
    onDismiss: () -> Unit,
    onAddParticipant: (String) -> Unit
) {
    var participantName by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Add Participant") },
        text = {
            TextField(
                value = participantName,
                onValueChange = { participantName = it },
                label = { Text("Participant Name") }
            )
        },
        confirmButton = {
            Button(onClick = {
                if (participantName.isNotBlank()) {
                    onAddParticipant(participantName)
                    onDismiss()
                }
            }) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}