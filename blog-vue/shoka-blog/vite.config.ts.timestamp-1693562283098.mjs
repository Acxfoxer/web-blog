// vite.config.ts
import vue from "file:///E:/LEI/web-blog/blog-vue/shoka-blog/node_modules/@vitejs/plugin-vue/dist/index.mjs";
import path from "path";
import AutoImport from "file:///E:/LEI/web-blog/blog-vue/shoka-blog/node_modules/unplugin-auto-import/dist/vite.js";
import { NaiveUiResolver } from "file:///E:/LEI/web-blog/blog-vue/shoka-blog/node_modules/unplugin-vue-components/dist/resolvers.mjs";
import Components from "file:///E:/LEI/web-blog/blog-vue/shoka-blog/node_modules/unplugin-vue-components/dist/vite.mjs";
import { defineConfig } from "file:///E:/LEI/web-blog/blog-vue/shoka-blog/node_modules/vite/dist/node/index.js";
import { prismjsPlugin } from "file:///E:/LEI/web-blog/blog-vue/shoka-blog/node_modules/vite-plugin-prismjs/dist/index.js";
import { createSvgIconsPlugin } from "file:///E:/LEI/web-blog/blog-vue/shoka-blog/node_modules/vite-plugin-svg-icons/dist/index.mjs";
var __vite_injected_original_dirname = "E:\\LEI\\web-blog\\blog-vue\\shoka-blog";
var vite_config_default = defineConfig({
  plugins: [
    vue(),
    AutoImport({
      imports: ["vue", "vue-router", "pinia"],
      dts: "src/types/auto-imports.d.ts"
    }),
    Components({
      resolvers: [NaiveUiResolver()],
      dts: "src/types/components.d.ts"
    }),
    createSvgIconsPlugin({
      iconDirs: [path.resolve(process.cwd(), "src/assets/icons")],
      symbolId: "icon-[dir]-[name]"
    }),
    prismjsPlugin({
      languages: [
        "java",
        "python",
        "html",
        "css",
        "sass",
        "less",
        "go",
        "cpp",
        "c",
        "js",
        "ts",
        "sql",
        "bash",
        "git",
        "nginx",
        "php"
      ],
      theme: "tomorrow",
      css: true
    })
  ],
  resolve: {
    alias: {
      "~": path.resolve(__vite_injected_original_dirname, "./"),
      "@": path.resolve(__vite_injected_original_dirname, "./src")
    },
    extensions: [".mjs", ".js", ".ts", ".jsx", ".tsx", ".json", ".vue"]
  },
  server: {
    open: true,
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        changeOrigin: true,
        rewrite: (path2) => path2.replace(/^\/api/, "")
      }
    }
  }
});
export {
  vite_config_default as default
};
//# sourceMappingURL=data:application/json;base64,ewogICJ2ZXJzaW9uIjogMywKICAic291cmNlcyI6IFsidml0ZS5jb25maWcudHMiXSwKICAic291cmNlc0NvbnRlbnQiOiBbImNvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9kaXJuYW1lID0gXCJFOlxcXFxMRUlcXFxcd2ViLWJsb2dcXFxcYmxvZy12dWVcXFxcc2hva2EtYmxvZ1wiO2NvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9maWxlbmFtZSA9IFwiRTpcXFxcTEVJXFxcXHdlYi1ibG9nXFxcXGJsb2ctdnVlXFxcXHNob2thLWJsb2dcXFxcdml0ZS5jb25maWcudHNcIjtjb25zdCBfX3ZpdGVfaW5qZWN0ZWRfb3JpZ2luYWxfaW1wb3J0X21ldGFfdXJsID0gXCJmaWxlOi8vL0U6L0xFSS93ZWItYmxvZy9ibG9nLXZ1ZS9zaG9rYS1ibG9nL3ZpdGUuY29uZmlnLnRzXCI7aW1wb3J0IHZ1ZSBmcm9tIFwiQHZpdGVqcy9wbHVnaW4tdnVlXCI7XHJcbmltcG9ydCBwYXRoIGZyb20gXCJwYXRoXCI7XHJcbmltcG9ydCBBdXRvSW1wb3J0IGZyb20gXCJ1bnBsdWdpbi1hdXRvLWltcG9ydC92aXRlXCI7XHJcbmltcG9ydCB7IE5haXZlVWlSZXNvbHZlciB9IGZyb20gXCJ1bnBsdWdpbi12dWUtY29tcG9uZW50cy9yZXNvbHZlcnNcIjtcclxuaW1wb3J0IENvbXBvbmVudHMgZnJvbSBcInVucGx1Z2luLXZ1ZS1jb21wb25lbnRzL3ZpdGVcIjtcclxuaW1wb3J0IHsgZGVmaW5lQ29uZmlnIH0gZnJvbSBcInZpdGVcIjtcclxuaW1wb3J0IHsgcHJpc21qc1BsdWdpbiB9IGZyb20gXCJ2aXRlLXBsdWdpbi1wcmlzbWpzXCI7XHJcbmltcG9ydCB7IGNyZWF0ZVN2Z0ljb25zUGx1Z2luIH0gZnJvbSBcInZpdGUtcGx1Z2luLXN2Zy1pY29uc1wiO1xyXG5cclxuLy8gaHR0cHM6Ly92aXRlanMuZGV2L2NvbmZpZy9cclxuZXhwb3J0IGRlZmF1bHQgZGVmaW5lQ29uZmlnKHtcclxuICBwbHVnaW5zOiBbXHJcbiAgICB2dWUoKSxcclxuICAgIEF1dG9JbXBvcnQoe1xyXG4gICAgICBpbXBvcnRzOiBbXCJ2dWVcIiwgXCJ2dWUtcm91dGVyXCIsIFwicGluaWFcIl0sXHJcbiAgICAgIGR0czogXCJzcmMvdHlwZXMvYXV0by1pbXBvcnRzLmQudHNcIixcclxuICAgIH0pLFxyXG4gICAgQ29tcG9uZW50cyh7XHJcbiAgICAgIHJlc29sdmVyczogW05haXZlVWlSZXNvbHZlcigpXSxcclxuICAgICAgZHRzOiBcInNyYy90eXBlcy9jb21wb25lbnRzLmQudHNcIixcclxuICAgIH0pLFxyXG4gICAgY3JlYXRlU3ZnSWNvbnNQbHVnaW4oe1xyXG4gICAgICAvLyBcdTYzMDdcdTVCOUFcdTk3MDBcdTg5ODFcdTdGMTNcdTVCNThcdTc2ODRcdTU2RkVcdTY4MDdcdTY1ODdcdTRFRjZcdTU5MzlcclxuICAgICAgaWNvbkRpcnM6IFtwYXRoLnJlc29sdmUocHJvY2Vzcy5jd2QoKSwgXCJzcmMvYXNzZXRzL2ljb25zXCIpXSxcclxuICAgICAgLy8gXHU2MzA3XHU1QjlBc3ltYm9sSWRcdTY4M0NcdTVGMEZcclxuICAgICAgc3ltYm9sSWQ6IFwiaWNvbi1bZGlyXS1bbmFtZV1cIixcclxuICAgIH0pLFxyXG4gICAgcHJpc21qc1BsdWdpbih7XHJcbiAgICAgIGxhbmd1YWdlczogW1xyXG4gICAgICAgIFwiamF2YVwiLFxyXG4gICAgICAgIFwicHl0aG9uXCIsXHJcbiAgICAgICAgXCJodG1sXCIsXHJcbiAgICAgICAgXCJjc3NcIixcclxuICAgICAgICBcInNhc3NcIixcclxuICAgICAgICBcImxlc3NcIixcclxuICAgICAgICBcImdvXCIsXHJcbiAgICAgICAgXCJjcHBcIixcclxuICAgICAgICBcImNcIixcclxuICAgICAgICBcImpzXCIsXHJcbiAgICAgICAgXCJ0c1wiLFxyXG4gICAgICAgIFwic3FsXCIsXHJcbiAgICAgICAgXCJiYXNoXCIsXHJcbiAgICAgICAgXCJnaXRcIixcclxuICAgICAgICBcIm5naW54XCIsXHJcbiAgICAgICAgXCJwaHBcIixcclxuICAgICAgXSxcclxuICAgICAgdGhlbWU6IFwidG9tb3Jyb3dcIixcclxuICAgICAgY3NzOiB0cnVlLFxyXG4gICAgfSksXHJcbiAgXSxcclxuICByZXNvbHZlOiB7XHJcbiAgICAvLyBodHRwczovL2NuLnZpdGVqcy5kZXYvY29uZmlnLyNyZXNvbHZlLWFsaWFzXHJcbiAgICBhbGlhczoge1xyXG4gICAgICAvLyBcdThCQkVcdTdGNkVcdThERUZcdTVGODRcclxuICAgICAgXCJ+XCI6IHBhdGgucmVzb2x2ZShfX2Rpcm5hbWUsIFwiLi9cIiksXHJcbiAgICAgIC8vIFx1OEJCRVx1N0Y2RVx1NTIyQlx1NTQwRFxyXG4gICAgICBcIkBcIjogcGF0aC5yZXNvbHZlKF9fZGlybmFtZSwgXCIuL3NyY1wiKSxcclxuICAgIH0sXHJcbiAgICAvLyBodHRwczovL2NuLnZpdGVqcy5kZXYvY29uZmlnLyNyZXNvbHZlLWV4dGVuc2lvbnNcclxuICAgIGV4dGVuc2lvbnM6IFtcIi5tanNcIiwgXCIuanNcIiwgXCIudHNcIiwgXCIuanN4XCIsIFwiLnRzeFwiLCBcIi5qc29uXCIsIFwiLnZ1ZVwiXSxcclxuICB9LFxyXG4gIHNlcnZlcjoge1xyXG4gICAgb3BlbjogdHJ1ZSxcclxuICAgIHByb3h5OiB7XHJcbiAgICAgIFwiL2FwaVwiOiB7XHJcbiAgICAgICAgdGFyZ2V0OiBcImh0dHA6Ly9sb2NhbGhvc3Q6ODA4MFwiLFxyXG4gICAgICAgIGNoYW5nZU9yaWdpbjogdHJ1ZSxcclxuICAgICAgICByZXdyaXRlOiAocGF0aCkgPT4gcGF0aC5yZXBsYWNlKC9eXFwvYXBpLywgXCJcIiksXHJcbiAgICAgIH0sXHJcbiAgICB9LFxyXG4gIH0sXHJcbn0pO1xyXG4iXSwKICAibWFwcGluZ3MiOiAiO0FBQXFTLE9BQU8sU0FBUztBQUNyVCxPQUFPLFVBQVU7QUFDakIsT0FBTyxnQkFBZ0I7QUFDdkIsU0FBUyx1QkFBdUI7QUFDaEMsT0FBTyxnQkFBZ0I7QUFDdkIsU0FBUyxvQkFBb0I7QUFDN0IsU0FBUyxxQkFBcUI7QUFDOUIsU0FBUyw0QkFBNEI7QUFQckMsSUFBTSxtQ0FBbUM7QUFVekMsSUFBTyxzQkFBUSxhQUFhO0FBQUEsRUFDMUIsU0FBUztBQUFBLElBQ1AsSUFBSTtBQUFBLElBQ0osV0FBVztBQUFBLE1BQ1QsU0FBUyxDQUFDLE9BQU8sY0FBYyxPQUFPO0FBQUEsTUFDdEMsS0FBSztBQUFBLElBQ1AsQ0FBQztBQUFBLElBQ0QsV0FBVztBQUFBLE1BQ1QsV0FBVyxDQUFDLGdCQUFnQixDQUFDO0FBQUEsTUFDN0IsS0FBSztBQUFBLElBQ1AsQ0FBQztBQUFBLElBQ0QscUJBQXFCO0FBQUEsTUFFbkIsVUFBVSxDQUFDLEtBQUssUUFBUSxRQUFRLElBQUksR0FBRyxrQkFBa0IsQ0FBQztBQUFBLE1BRTFELFVBQVU7QUFBQSxJQUNaLENBQUM7QUFBQSxJQUNELGNBQWM7QUFBQSxNQUNaLFdBQVc7QUFBQSxRQUNUO0FBQUEsUUFDQTtBQUFBLFFBQ0E7QUFBQSxRQUNBO0FBQUEsUUFDQTtBQUFBLFFBQ0E7QUFBQSxRQUNBO0FBQUEsUUFDQTtBQUFBLFFBQ0E7QUFBQSxRQUNBO0FBQUEsUUFDQTtBQUFBLFFBQ0E7QUFBQSxRQUNBO0FBQUEsUUFDQTtBQUFBLFFBQ0E7QUFBQSxRQUNBO0FBQUEsTUFDRjtBQUFBLE1BQ0EsT0FBTztBQUFBLE1BQ1AsS0FBSztBQUFBLElBQ1AsQ0FBQztBQUFBLEVBQ0g7QUFBQSxFQUNBLFNBQVM7QUFBQSxJQUVQLE9BQU87QUFBQSxNQUVMLEtBQUssS0FBSyxRQUFRLGtDQUFXLElBQUk7QUFBQSxNQUVqQyxLQUFLLEtBQUssUUFBUSxrQ0FBVyxPQUFPO0FBQUEsSUFDdEM7QUFBQSxJQUVBLFlBQVksQ0FBQyxRQUFRLE9BQU8sT0FBTyxRQUFRLFFBQVEsU0FBUyxNQUFNO0FBQUEsRUFDcEU7QUFBQSxFQUNBLFFBQVE7QUFBQSxJQUNOLE1BQU07QUFBQSxJQUNOLE9BQU87QUFBQSxNQUNMLFFBQVE7QUFBQSxRQUNOLFFBQVE7QUFBQSxRQUNSLGNBQWM7QUFBQSxRQUNkLFNBQVMsQ0FBQ0EsVUFBU0EsTUFBSyxRQUFRLFVBQVUsRUFBRTtBQUFBLE1BQzlDO0FBQUEsSUFDRjtBQUFBLEVBQ0Y7QUFDRixDQUFDOyIsCiAgIm5hbWVzIjogWyJwYXRoIl0KfQo=
