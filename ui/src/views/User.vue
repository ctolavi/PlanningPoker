<template>
  <v-container fill-height fluid>
    <v-row align="center" justify="center">
      <v-col cols="5" md="4" sm="11">
        <v-card class="pa-6">
          <v-row justify="center">
            <v-card-text>
              <v-card-title>Join to Planning Poker</v-card-title>
              <v-text-field
                @keydown.enter="login"
                dense
                label="Name"
                outlined
                prepend-inner-icon="mdi-account-circle"
                v-model="user"
              ></v-text-field>
            </v-card-text>
          </v-row>
          <v-row justify="center">
            <v-btn
              :disabled="!user"
              @click="login"
              color="info"
            >
              Enter
            </v-btn>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  import User from "../api/User";
  import {mapMutations} from "vuex";

  export default {
    name: "User",
    data() {
      return {
        user: null,
      }
    },
    methods: {
      ...mapMutations([
        'setUser',
      ]),
      login() {
        let user = {name: this.user};
        User.save(user).then(
          user => {
            this.setUser(user);
            this.$router.push({name: "Rooms"})
          }
        );
      }
    }
  }
</script>

<style scoped>

</style>
