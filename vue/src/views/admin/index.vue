<template>
  <div>
    <h1> {{ current }} </h1>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  data() {
    return {
      current: 'ready'
    }
  },
  computed: {
    ...mapGetters([
      'roles'
    ])
  },
  created() {
    if (!this.roles.includes('admin')) {
      this.current = 'admin'
    } else {
      this.current = 'editor'
    }
  }
}
</script>
