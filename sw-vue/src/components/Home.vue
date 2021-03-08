<template>
  <div>
    <Header></Header>
    <router-view/>
  </div>
</template>

<script>
import Header from './common/Header'

export default {
  name: 'Home',
  components: { Header }
}
</script>

<style scoped>

</style>
