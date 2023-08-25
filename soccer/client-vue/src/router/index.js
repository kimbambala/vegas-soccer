import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Monday from "../views/Monday.vue"
import Tuesday from "../views/Tuesday.vue"
import Wednesday from "../views/Wednesday.vue"
import Thursday from "../views/Thursday.vue"
import Friday from "../views/Friday.vue"
import Saturday from "../views/Saturday.vue"
import Sunday from "../views/Sunday.vue"
import Profile from "../views/Profile.vue"
import Edit from "../views/Edit.vue"
import Create from "../views/Create.vue"

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: '/groups/monday',
      name: 'monday',
      component: Monday,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: '/groups/tuesday',
      name: 'tuesday',
      component: Tuesday,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: '/groups/wednesday/',
      name: 'wednesday',
      component: Wednesday,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: '/groups/thursday/',
      name: 'thursday',
      component: Thursday,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: '/groups/friday/',
      name: 'friday',
      component: Friday,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: '/groups/saturday/',
      name: 'saturday',
      component: Saturday,
      meta: {
        requiresAuth: false
      }
    },


    {
      path: "/profile/:userId",
      name: "profile",
      component: Profile,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/groups/edit/:groupId",
      name: "edit",
      component: Edit,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/groups/create/:userId",
      name: "create",
      component: Create,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: '/groups/sunday/',
      name: 'sunday',
      component: Sunday,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
