import Vue from 'vue';
import Router from 'vue-router';
import User from "./views/User"
import Rooms from "./views/Rooms";
import Room from "./views/Room";

Vue.use(Router);

export default new Router({
  base: process.env.BASE_URL,
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'User',
      component: User,
    },
    {
      path: '/rooms',
      name: 'Rooms',
      component: Rooms,
    },
    {
      path: '/rooms/:id',
      name: 'Room',
      props: true,
      component: Room,
    }
  ],
});
