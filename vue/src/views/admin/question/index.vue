<template>
  <div>
    <h1>문제 관리</h1>
    {{ test }}
    {{ $route.query.test }}
    {{ testTwo }}
  </div>
</template>

<script>
export default {
  data() {
    return {
      test: this.$route.query.test,
      testTwo: 'test2'
    }
  }
}
</script>
