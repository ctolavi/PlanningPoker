<template>
  <v-card>
    <v-card-title>
      <span class="headline">Create Room</span>
    </v-card-title>
    <v-card-text>
      <v-row>
        <v-col cols="12">
          <v-text-field
            dense
            label="Room name"
            outlined
            v-model="name"></v-text-field>
        </v-col>
      </v-row>
    </v-card-text>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn :disabled="!name" @click="save" color="save" text>Save</v-btn>
      <v-btn @click="close" color="cancel" text>Cancel</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
  import Room from "../api/Room";

  export default {
    name: "CreateRoom",
    data() {
      return {
        name: null,
      }
    },
    methods: {
      close() {
        this.$emit('closed', false);
      },
      save() {
        let room = {
          name: this.name,
        }
        Room.save(room).then(
          response => {
            this.name = null;
            this.$emit('closed', false);
          }
        )
      },
    }
  }
</script>
