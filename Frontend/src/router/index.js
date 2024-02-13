import { createRouter, createWebHistory } from "vue-router";
import Cithub from '../CithubHomeView.vue'

// Repository
import Repository_Router from '../repository/RepositoryRouter.vue'
import Repository_Home from '../repository/Home.vue'
import Repository_Papers from '../repository/Papers.vue'
import Repository_Scholars from '../repository/Scholars.vue'
import Repository_Fields from '../repository/Fields.vue'
import Repository_Venues from '../repository/Venues.vue'
import Repository_Statistics from '../repository/Statistics.vue'
import ChartsDisplay from '../repository/ChartsDisplay.vue'

// Tools
import ToolsRouterView from '../ToolsViews/ToolsRouterView.vue'
import ToolsHome from '../ToolsViews/ToolsHome.vue'
import ModelsHome from '../ToolsViews/ModelsHome.vue'

// Benchmark
import BenchmarkRouterView from '../BenchmarkViews/BenchmarkRouterView.vue'
import BenchmarkHome from '../BenchmarkViews/BenchmarkHome.vue'

// User
import UserRouterView from '../UserViews/UserRouterView.vue'
import UserHome from '../UserViews/UserHome.vue'
import UserLogin from '../UserViews/UserLogin.vue'
import UserRegister from '../UserViews/UserRegister.vue'


const routes = [
  {
    path: "/",
    name: "Cithub",
    component: Cithub,
    meta: { title: 'Cithub' }
  },
  // Repository
  {
    path: '/repository',
    component: Repository_Router,
    meta: { title: 'Router' },
    children: [
      {
        path: "home",
        name: 'Repository_Home',
        component: Repository_Home,
        meta: { title: 'Home' }
      },
      {
        path: "papers",
        name: "Repository_Papers",
        component: Repository_Papers,
        meta: { title: 'Papers' }
      },
      {
        path: "scholars",
        name: "Repository_Scholars",
        component: Repository_Scholars,
        meta: { title: 'Scholars' }
      },
      {
        path: "fields",
        name: "Repository_Fields",
        component: Repository_Fields,
        meta: { title: 'Fields' }
      },
      {
        path: "venues",
        name: "Repository_Venues",
        component: Repository_Venues,
        meta: { title: 'Venue' }
      },
      {
        path: "statistics",
        name: "Repository_Statistics",
        component: Repository_Statistics,
        meta: { title: 'Statistics' }
      },
      {
        path: "ChartsDisplay",
        name: "ChartsDisplay",
        component: ChartsDisplay,
        meta: { title: 'ChartsDisplay' }
      },
    ]
  },

  // Tools
  {
    path: '/tools',
    component: ToolsRouterView,
    meta: { title: 'Tools' },
    children: [
      {
        // ToolsHome
        path: "home",
        name: 'algorithmHome',
        component: ToolsHome,
        meta: { title: 'Tools' }
      },
      {
        // ToolsHome
        path: "models",
        name: 'modelsHome',
        component: ModelsHome,
        meta: { title: 'Models' }
      },

    ]
  },
  // Benchmark
  {
    path: '/benchmark',
    component: BenchmarkRouterView,
    meta: { title: 'Benchmark' },
    children: [
      {
        // BenchmarkHome
        path: "home",
        name: 'benchmarkHome',
        component: BenchmarkHome,
        meta: { title: 'Benchmark' }
      },

    ]
  },


  // User
  {
    path: '/user',
    component: UserRouterView,
    meta: { title: 'User' },
    children: [
      {
        path: "login",
        name: 'UserLogin',
        component: UserLogin,
        meta: { title: 'UserLogin' }
      },
      {
        path: "register",
        name: 'UserRegister',
        component: UserRegister,
        meta: { title: 'UserRegister' }
      },

    ]
  },



];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkActiveClass: "active",
});

router.beforeEach((to, from, next) => {
  window.document.title = to.meta.title
  next()
})

export default router;
