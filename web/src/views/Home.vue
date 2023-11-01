<template>
  <div class="home">
    <a-button type="primary">Primary</a-button>
    <a-button>default</a-button>
    <a-button type="danger" >Danger</a-button>
    <a-button type="dashed" >Dashed</a-button>
    <a-button type="text" >Text</a-button>
    <a-button type="link" >Link</a-button>
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src

export default defineComponent({
  name: 'Home',
  components: {
    HelloWorld,
  },
});
</script>
