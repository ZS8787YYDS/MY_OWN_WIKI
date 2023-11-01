/*引入createApp函数*/
import { createApp } from 'vue'
//引入根组件
import App from './App.vue'
//router路由
import router from './router'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import store from './store'
//创建vue对象，调用use函数在当前项目中使用路由，调用mount函数，指定当前对象所挂载的元素为id属性值为app的元素
createApp(App).use(store).use(router).use(Antd).mount('#app')