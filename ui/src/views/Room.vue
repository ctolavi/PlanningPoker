<template>
  <v-container>
    <v-row align="center" justify="center">
      {{room.name}}
    </v-row>
    <v-row>
      <v-col cols="12" md="9" sm="12">
        <v-row>
          <v-col :key="i" cols="3" md="2" sm="3"
                 v-for="(card,i) in cards">
            <v-card class="py-md-16 py-sm-4">
              <span class="text-h2">
                {{card}}
              </span>
            </v-card>
          </v-col>
        </v-row>
      </v-col>
      <v-col cols="12" md="3" sm="12">
        <v-card width="100%">
          <span>Options</span>
          <div :key="i" v-for="(player, i) in players">
            <span>{{player.name}}</span>
          </div>
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-card width="100%">
        <v-container>
          <v-row class="mx-2">
            <span>Stories</span>
            <v-spacer></v-spacer>
            <v-btn
              @click="storyDialog=true"
              color="info"
              icon
            >
              <v-icon>
                mdi-plus
              </v-icon>
            </v-btn>
          </v-row>
          <v-divider></v-divider>
          <div :key="j" v-for="(story, j) in stories">
            <span>{{story.name}}</span>
          </div>
        </v-container>
      </v-card>
    </v-row>
    <v-dialog max-width="400px" persistent v-model="storyDialog">
      <v-card>
        <v-card-title>
          Create Story
        </v-card-title>
        <v-textarea
          auto-grow
          class="mx-4"
          dense
          outlined
          rows="2"
          v-model="storyName"></v-textarea>
        <v-card-actions>
          <v-btn @click="saveAndNew">
            Save & New
          </v-btn>
          <v-btn @click="save">
            Save
          </v-btn>
          <v-btn @click="storyDialog=false">
            Close
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
  import Room from "../api/Room";
  import User from "../api/User";

  export default {
    name: "Room",
    props: ['id'],
    data() {
      return {
        room: {},
        players: [],
        stories: [],
        storyDialog: false,
        storyName: null,
        cards: [0, '1 / 2', 1, 2, 3, 5, 8, 13, 20, 40, 100, '?', 'coffee'],
      }
    },
    mounted() {
      //TODO actualizar el get by id
      Room.get(this.id).then(
        room => {
          this.room = room;
          //TODO sacar los usuarios de un room
          return User.get(this.id);
        }
      ).then(
        players => {
          this.players = players;
          return Room.getStoryByRoom(this.id);
        }
      ).then(
        stories => {
          this.stories = stories;
        }
      );
    },
    methods: {
      saveAndNew() {
        this.saveStory();
      },
      save() {
        this.saveStory();
        this.storyDialog = false;
      },
      saveStory() {
        let story = {
          name: this.storyName,
        };
        Room.saveStoryByRoom(this.id, story).then(
          storySaved => {
            this.storyName = null;
            return Room.getStoryByRoom(this.id);
          }
        ).then(
          stories => {
            this.stories = stories;
          }
        );
      },
    }
  }
</script>

<style scoped>

</style>
