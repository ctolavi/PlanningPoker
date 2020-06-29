<template>
  <div>
    <v-row align="center" justify="center">
      <v-col cols="5" md="8" sm="11">
        <v-btn @click="createRoomDialog=true" color="info">
          Create Room
        </v-btn>
        <v-card class="pa-4 mt-3">
          <v-row>
            <v-col>
              Room Name
            </v-col>
          </v-row>
          <v-divider></v-divider>
          <div
            :key="i"
            v-for="(room, i) in rooms">
            <v-row>
              <v-col>
                <span @click="$router.push({name: 'Room',  params: { id: room.id}})">
                  {{room.name}}
                </span>
              </v-col>
            </v-row>
            <v-divider></v-divider>
          </div>
        </v-card>
      </v-col>
    </v-row>
    <v-dialog max-width="400px" persistent v-model="createRoomDialog">
      <create-room @closed="createRoomDialog=false"></create-room>
    </v-dialog>
  </div>
</template>

<script>
  import Room from "../api/Room";
  import CreateRoom from "./CreateRoom";

  export default {
    name: "Rooms",
    components: {CreateRoom},
    data() {
      return {
        rooms: [],
        createRoomDialog: false,
      }
    },
    mounted() {
      Room.get().then(
        rooms => {
          this.rooms = rooms;
        }
      );
    }
  }
</script>
